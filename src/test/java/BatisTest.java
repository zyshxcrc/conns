import algorithm.InsertSort;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/6/27.
 */
public class BatisTest {
    public static void main(String[] args) {
        String resourcs = "/java/resources/mybatis-config.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(resourcs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.getMapper(InsertSort.class);

    }
}
