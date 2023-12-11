import java.util.ArrayList;
import java.util.List;

/**
 * Lớp Person đại diện cho một người trong hệ thống genealogy.
 */
public class Person {
    private String name;
    private String birthDate;
    private String gender;
    private String wedding;
    private List<Person> children;
    private Person parent;

    /**
     * Constructor để tạo một đối tượng Person với thông tin cơ bản.
     *
     * @param name      Tên của người.
     * @param birthDate Ngày sinh của người.
     * @param gender    Giới tính của người.
     * @param wedding   Ngày cưới (nếu có) của người.
     */
    public Person(String name, String birthDate, String gender, String wedding) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.wedding = wedding;
        this.children = new ArrayList<>();
    }

    /**
     * Thêm một đứa con cho người này.
     *
     * @param child Đối tượng Person đại diện cho đứa con được thêm.
     */
    public void addChild(Person child) {
        children.add(child);
        child.parent = this;
    }

    /**
     * Lấy tên của người.
     *
     * @return Tên của người.
     */
    public String getName() {
        return name;
    }

    /**
     * Lấy ngày sinh của người.
     *
     * @return Ngày sinh của người.
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Lấy giới tính của người.
     *
     * @return Giới tính của người.
     */
    public String getGender() {
        return gender;
    }

    /**
     * Lấy ngày cưới của người.
     *
     * @return Ngày cưới của người hoặc null nếu chưa cưới.
     */
    public String getWedding() {
        return wedding;
    }

    /**
     * Lấy danh sách các đứa con của người.
     *
     * @return Danh sách các đối tượng Person đại diện cho đứa con.
     */
    public List<Person> getChildren() {
        return children;
    }

    /**
     * Kiểm tra xem người này có phải đã cưới hay chưa.
     *
     * @return true nếu đã cưới, ngược lại false.
     */
    public boolean isMarried() {
        return wedding != null;
    }

    /**
     * Kiểm tra xem người này có hai đứa con hay không.
     *
     * @return true nếu có hai đứa con, ngược lại false.
     */
    public boolean hasTwoChildren() {
        return children.size() == 2;
    }

    /**
     * Kiểm tra xem người này có phải là thế hệ mới nhất hay không.
     *
     * @return true nếu là thế hệ mới nhất, ngược lại false.
     */
    public boolean isLatestGeneration() {
        return children.isEmpty() && parent != null;
    }

    /**
     * Phương thức toString để hiển thị thông tin cơ bản của người.
     *
     * @return Chuỗi chứa thông tin về tên, ngày sinh và giới tính của người.
     */
    public String toString() {
        return "Name: " + this.name + ", Date of birth: " + this.birthDate + ", Gender: " + this.gender;
    }
}
