import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class PurchaseKey implements Serializable {
    @Column(name = "student_name", insertable = false, updatable = false, nullable = false, length = 150)
    private String studentName;
    @Column(name = "course_name", insertable = false, updatable = false, nullable = false, length = 150)
    private String courseName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseKey that)) return false;
        return getStudentName().equals(that.getStudentName()) && getCourseName().equals(that.getCourseName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentName(), getCourseName());
    }
}
