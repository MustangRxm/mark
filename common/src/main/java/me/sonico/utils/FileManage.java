package me.sonico.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 * @author Jack
 * @time 2016/11/8 0008 1:04
 * @des TODO
 */
public class FileManage {
    private  Auth auth = null;

    public FileManage(){
        auth = Auth.create(Constant.ACCESS_KEY,Constant.SECRET_KEY);
    }
    public String getUpToken(){
        return auth.uploadToken(Constant.BUCKET_NAME);
    }
    /**
     * @param key 上传到七牛后保存的文件名
     * @param FilePath 上传文件的路径
     */
    public   void upLoadFile(String FilePath,String key){
        //创建上传对象
        UploadManager uploadManager = new UploadManager();
        try {
            //调用put方法上传
            Response res = uploadManager.put(FilePath, key, getUpToken());
            //打印返回的信息
            System.out.println(res.bodyString());
        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
    }


    public void downLoadFile(){

    }
}
