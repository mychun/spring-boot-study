package com.chun.springbootstudy.service.imp;

import com.chun.springbootstudy.config.LuceneConfig;
import com.chun.springbootstudy.domain.User;
import com.chun.springbootstudy.req.UserQuery;
import com.chun.springbootstudy.service.LuceneService;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LuceneServiceImpl implements LuceneService {
    @Autowired
    private IndexWriter indexWriter;

    @Autowired
    private Analyzer analyzer;

    @Autowired
    private SearcherManager searcherManager;

    private Document createDoc(User u){
        Document doc = new Document();

        doc.add(new StringField("id", u.getId() + "", Field.Store.YES));
        doc.add(new TextField("name", u.getName(), Field.Store.YES));
        doc.add(new StringField("account", u.getAccount(), Field.Store.YES));
        doc.add(new StringField("age", u.getAge() + "", Field.Store.YES));

        //无需根据密码查询，所以密码只存储，不分词，不索引
        doc.add(new StoredField("password", u.getPassword()));
        return doc;
    }

    @Override
    public void createUserIndex(List<User> userList) throws IOException {
        List<Document> docs = new ArrayList<>();
        for (User u : userList) {
            docs.add(createDoc(u));
        }

        indexWriter.addDocuments(docs);
        indexWriter.commit();
        //indexWriter.close();
    }

    @Override
    public void updateUerIndex(User u) throws IOException {
        /* 修改索引。参数：
         * 	词条：根据这个词条匹配到的所有文档都会被修改
         * 	文档信息：要修改的新的文档数据
         */
        indexWriter.updateDocument(new Term("id", String.valueOf(u.getId())), createDoc(u));
        // 提交
        indexWriter.commit();
        // 关闭
        // indexWriter.close();
    }

    @Override
    public UserQuery searchUser(UserQuery userQuery) throws Exception, ParseException {
        searcherManager.maybeRefresh();
        IndexSearcher indexSearcher = searcherManager.acquire();

//        Analyzer analyzer = new IKAnalyzer(true);
//        DirectoryReader directoryReader = DirectoryReader.open(FSDirectory.open(Paths.get(LuceneConfig.LUCENEINDEXPATH)));
//        //索引查询器
//        IndexSearcher indexSearcher = new IndexSearcher(directoryReader);

        User params = userQuery.getParams();
//        Map<String, String> queryParam = userQuery.getQueryParam();
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        Sort sort = new Sort();
        // 排序规则
        com.chun.springbootstudy.domain.Sort sort1 = userQuery.getSort();
        if (sort1 != null && sort1.getOrder() != null) {
            if ("ASC".equals(sort1.getOrder().toUpperCase())) {
                sort.setSort(new SortField(sort1.getField(), SortField.Type.FLOAT, false));
            } else if ("DESC".equals((sort1.getOrder()).toUpperCase())) {
                sort.setSort(new SortField(sort1.getField(), SortField.Type.FLOAT, true));
            }
        }

        // 模糊匹配,匹配词
        String keyStr = params.getName();
        if (params != null && params.getName() != null) {
            // 输入空格,不进行模糊查询
            if (!"".equals(keyStr.replaceAll(" ", ""))) {
                builder.add(new QueryParser("name", analyzer).parse(keyStr), BooleanClause.Occur.MUST);
            }
        }

        // 精确查询
        if (params != null && params.getId() != null) {
            builder.add(new TermQuery(new Term("id", String.valueOf(params.getId()))), BooleanClause.Occur.MUST);
        }

//        PageInfo pageInfo = userQuery.getPageInfo();
//        TopDocs topDocs = indexSearcher.search(builder.build(), pageInfo.getPageNum() * pageInfo.getPageSize(), sort);

        //1，可以做分页
        int currentPage = 10; //当前页码
        TopDocs topDocs = indexSearcher.search(builder.build(), currentPage, sort);
        System.out.println("符合条件的文档数：" + topDocs.totalHits.value);

        ScoreDoc[] hits = topDocs.scoreDocs;
        List<User> uList = new ArrayList<User>();
        for (int i = 0; i < hits.length; i++) {
            Document doc = indexSearcher.doc(hits[i].doc);
            User user = new User();
            user.setId(Integer.parseInt(doc.get("id")));
            user.setName(doc.get("name"));
            user.setAge(Integer.parseInt(doc.get("age")));
            user.setAccount(doc.get("account"));
            user.setPassword(doc.get("password"));
            uList.add(user);
        }
        userQuery.setResults(uList);
        return userQuery;
    }

    @Override
    public void deleteUserIndexById(String id) throws IOException {
        indexWriter.deleteDocuments(new Term("id",id));
        indexWriter.commit();
    }

}
