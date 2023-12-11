import java.io.*;

/**
 * Lớp tiện ích cung cấp các phương thức để đọc, ghi và thao tác với tệp tin.
 */
public class Utils {

    /**
     * Đọc nội dung của tệp tin và trả về dưới dạng StringBuilder.
     *
     * @param filePath Đường dẫn của tệp tin cần đọc.
     * @return StringBuilder chứa nội dung của tệp tin.
     */
    public static StringBuilder readFileStream(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            BufferedReader inputReader = new BufferedReader(new FileReader(filePath));
            String lines;
            while ((lines = inputReader.readLine()) != null) {
                fileContent.append(lines).append("\n");
            }
            inputReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileContent;
    }

    /**
     * Ghi nội dung vào tệp tin.
     *
     * @param fileContent Nội dung cần ghi vào tệp tin.
     * @param filePath    Đường dẫn của tệp tin cần ghi.
     */
    public static void writeFileStream(String fileContent, String filePath) {
        try {
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter(filePath));
            outputWriter.write(fileContent);
            outputWriter.close();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    /**
     * Tìm kiếm tệp tin trong một thư mục dựa trên tên tệp tin.
     *
     * @param folderPath Đường dẫn của thư mục.
     * @param fileName   Tên tệp tin cần tìm kiếm.
     * @return Đối tượng File của tệp tin nếu tìm thấy, ngược lại trả về null.
     */
    public static File searchFileName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.getName().equals(fileName)) {
                    return f;
                }
            }
        }
        return null;
    }

    /**
     * Ghi thêm nội dung vào tệp tin mà không ghi đè nội dung hiện tại.
     *
     * @param fileContent Nội dung cần thêm vào tệp tin.
     * @param filePath    Đường dẫn của tệp tin cần thêm.
     */
    public static void appendContentToFile(String fileContent, String filePath) {
        try {
            StringBuilder currentContent = readFileStream(filePath);
            BufferedWriter output = new BufferedWriter(new FileWriter(filePath));
            output.write(currentContent.toString() + "\n" + fileContent);

            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Phương thức chính không có tham số.
     *
     * @param args Tham số dòng lệnh.
     */
    public static void main(String[] args) {
    }
}
