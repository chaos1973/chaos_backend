package com.chaos.qiniuyun.utils;

/**
 * @projectName: pic_up_down
 * @package: com.chaos.qiniuyun.utils
 * @className: T
 * @author: chaos
 * @description: TODO
 * @date: 2022/11/18 14:21
 * @version: 1.0
 */

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.util.StringUtils;

public class QiniuCloudUtil {

    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";

    // 要上传的空间
    private static final String bucketname = "";

    // 密钥
    //private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    private static final String DOMAIN = "";;

    //private static final String style = "png";

//    public String getUpToken() {
//        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
//    }
    // 普通上传
//    public String upload(String filePath, String fileName) throws IOException {
//        // 创建上传对象
//        UploadManager uploadManager = new UploadManager();
//        try {
//            // 调用put方法上传
//            String token = auth.uploadToken(bucketname);
//            if(StringUtils.hasLength(token)) {
//                System.out.println("未获取到token，请重试！");
//                return null;
//            }
//            Response res = uploadManager.put(filePath, fileName, token);
//            // 打印返回的信息
//            System.out.println(res.bodyString());
//            if (res.isOK()) {
//                Ret ret = res.jsonToObject(Ret.class);
//
//                return DOMAIN + ret.key;
//                //如果需要对图片进行样式处理，则使用以下方式即可
//                //return DOMAIN + ret.key + "?" + style;
//            }
//        } catch (QiniuException e) {
//            Response r = e.response;
//            // 请求失败时打印的异常的信息
//            System.out.println(r.toString());
//            try {
//                // 响应的文本信息
//                System.out.println(r.bodyString());
//            } catch (QiniuException e1) {
//                // ignore
//            }
//        }
//        return null;
//    }


    //base64方式上传
//    public String put64image(byte[] base64, String key) throws Exception{
//        String file64 = Base64.encodeToString(base64, 0);
//        Integer l = base64.length;
//        String url = "http://upload.qiniu.com/putb64/" + l + "/key/"+ UrlSafeBase64.encodeToString(key);
//        //非华东空间需要根据注意事项 1 修改上传域名
//        RequestBody rb = RequestBody.create(null, file64);
//        Request request = new Request.Builder().
//                url(url).
//                addHeader("Content-Type", "application/octet-stream")
//                .addHeader("Authorization", "UpToken " + getUpToken())
//                .post(rb).build();
//        //System.out.println(request.headers());
//        OkHttpClient client = new OkHttpClient();
//        okhttp3.Response response = client.newCall(request).execute();
//        System.out.println(response);
//
//        return DOMAIN + key;
//        //如果需要添加图片样式，使用以下方式
//        //return DOMAIN + key + "?" + style;
//    }


    // 普通删除(暂未使用以下方法，未测试)
//    public void delete(String key) throws IOException {
//        // 实例化一个BucketManager对象
//        BucketManager bucketManager = new BucketManager(auth);
//        // 此处的33是去掉：http://ongsua0j7.bkt.clouddn.com/,剩下的key就是图片在七牛云的名称
//        key = key.substring(33);
//        try {
//            // 调用delete方法移动文件
//            bucketManager.delete(bucketname, key);
//        } catch (QiniuException e) {
//            // 捕获异常信息
//            Response r = e.response;
//            System.out.println(r.toString());
//        }
//    }

    class Ret {
        public long fsize;
        public String key;
        public String hash;
        public int width;
        public int height;
    }
    public  String uploadAgain(){
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.regionCnEast2());
        cfg.resumableUploadAPIVersion = Configuration.ResumableUploadAPIVersion.V2;// 指定分片上传版本
//...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
//...生成上传凭证，然后准备上传
        String accessKey = "your access key";
        String secretKey = "your secret key";
        String bucket = "your bucket name";
//如果是Windows情况下，格式是 D:\\qiniu\\test.png
        String localFilePath  = "D:\\All_Pro\\GitHub_backend\\chaos_backend\\qiniuyun\\src\\main\\java\\com\\chaos\\qiniuyun\\controller\\logo1.jpg";
//默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(bucketname);
        try {
            Response response = uploadManager.put(localFilePath, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "";
    }
}