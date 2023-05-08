package bismastrFramework.data;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class DataReader {

    public void getJsonToMap() throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "//src//test//java//bismastrFramework//data//PurchaseOrder.json") );

    }
}
