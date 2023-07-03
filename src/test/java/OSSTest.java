import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import org.junit.jupiter.api.Test;

public class OSSTest {
    @Test
    public void test() {
        String bucketName = "online-store-wenruyv";  // 存储桶名称
        // 创建 OSS 客户端实例
        // RAM用户的访问密钥（AccessKey ID和AccessKey Secret）。
        String accessKeyId = "";
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeySecret = "";
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 获取存储桶中的所有文件信息
            ObjectListing objectListing = ossClient.listObjects(bucketName);
            for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
                // 修改对象的 ACL 权限为公共读
                ossClient.setObjectAcl(bucketName, objectSummary.getKey(), CannedAccessControlList.PublicRead);
            }
            System.out.println("所有对象的读写权限已修改为公共读");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 关闭 OSS 客户端连接
            ossClient.shutdown();
        }
    }
}
