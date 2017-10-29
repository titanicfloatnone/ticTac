package is.ru.tictactoe;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;

import java.util.List;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Date;


public class DropBox {
    private static final String ACCESS_TOKEN ="IPJbs9-WCVoAAAAAAAAS7vF3FifM2yeGyaGBBQlkzOrn6PEbVXVM-vTsXx0g-b-r";
    DropBox() {
      // CREATE DROPBOX CLIENT
      try {
        DbxRequestConfig config = new DbxRequestConfig("Docs_late_term_assignment/v1", "en_US");
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
        FullAccount account = client.users().getCurrentAccount();
        Date now = new Date();
        try (InputStream in = new FileInputStream("build/gen-html/DesignReport.html")) {
          FileMetadata metadata = client.files().uploadBuilder("/DesignReport"+now+".html")
        .uploadAndFinish(in);
        }
        try (InputStream in = new FileInputStream("build/gen-html/AdminManual.html")) {
          FileMetadata metadata = client.files().uploadBuilder("/AdminManual"+now+".html")
        .uploadAndFinish(in);
        }
        try (InputStream in = new FileInputStream("build/gen-html/DevManual.html")) {
          FileMetadata metadata = client.files().uploadBuilder("/DevManual"+now+".html")
        .uploadAndFinish(in);
        }
        try (InputStream in = new FileInputStream("build/reports/jacoco/test/html/index.html")) {
          FileMetadata metadata = client.files().uploadBuilder("/CodeCoverage"+now+".html")
        .uploadAndFinish(in);
        }
      }
      catch(Exception e) {
        System.out.println(e.getMessage());
      }
    }
}
