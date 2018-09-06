import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by wangs002 on 2018/9/4.
 */
public class HttpClientUtilTest {

    @Test
    public void testSendHttpPost1() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:5601/api/console/proxy?path=acclog-2018.09.04%2F_search&method=POST");
        System.out.println("reponse content:" + responseContent);
    }

    @Test
    public void testSendHttpPost2() {
        String body = "{\"index\":[\"applog-*\"],\"ignore_unavailable\":true,\"preference\":1536042694776}\n" +
                "{\"version\":true,\"size\":500,\"sort\":[{\"@timestamp\":{\"order\":\"desc\",\"unmapped_type\":\"boolean\"}}],\"query\":{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"service:um\",\"analyze_wildcard\":true}},{\"range\":{\"@timestamp\":{\"gte\":1535990400000,\"lte\":1536076799999,\"format\":\"epoch_millis\"}}}],\"must_not\":[]}},\"_source\":{\"excludes\":[\"hostname\"]},\"aggs\":{\"2\":{\"date_histogram\":{\"field\":\"@timestamp\",\"interval\":\"30m\",\"time_zone\":\"Asia/Shanghai\",\"min_doc_count\":1}}},\"stored_fields\":[\"*\"],\"script_fields\":{},\"docvalue_fields\":[\"@timestamp\"],\"highlight\":{\"pre_tags\":[\"@kibana-highlighted-field@\"],\"post_tags\":[\"@/kibana-highlighted-field@\"],\"fields\":{\"*\":{\"highlight_query\":{\"bool\":{\"must\":[{\"query_string\":{\"query\":\"service:um\",\"analyze_wildcard\":true,\"all_fields\":true}},{\"range\":{\"@timestamp\":{\"gte\":1535990400000,\"lte\":1536076799999,\"format\":\"epoch_millis\"}}}],\"must_not\":[]}}}},\"fragment_size\":2147483647}}\n";
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:5601/elasticsearch/_msearch", body);
        System.out.println("reponse content:" + responseContent);
    }

    @Test
    public void testSendHttpPost3() {
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("username", "test01");
        maps.put("password", "123456");
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:8089/test/send", maps);
        System.out.println("reponse content:" + responseContent);
    }

    @Test
    public void testSendHttpPost4() {
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("username", "test01");
        maps.put("password", "123456");
        List<File> fileLists = new ArrayList<File>();
        fileLists.add(new File("D://test//httpclient//1.png"));
        fileLists.add(new File("D://test//httpclient//1.txt"));
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpPost("http://localhost:8089/test/sendpost/file", maps, fileLists);
        System.out.println("reponse content:" + responseContent);
    }

    @Test
    public void testSendHttpGet() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpGet("http://localhost:8089/test/send?username=test01&password=123456");
        System.out.println("reponse content:" + responseContent);
    }

    @Test
    public void testSendHttpsGet() {
        String responseContent = HttpClientUtil.getInstance()
                .sendHttpsGet("https://www.baidu.com");
        System.out.println("reponse content:" + responseContent);
    }

}
