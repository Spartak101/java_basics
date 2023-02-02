import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class LinkedPurchaseListKey implements Serializable {

    @Column(name = "student_id", insertable = false, updatable = false, nullable = false, length = 150)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false, nullable = false, length = 150)
    private Integer courseId;


    public LinkedPurchaseListKey() {
    }

    public LinkedPurchaseListKey(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedPurchaseListKey that)) return false;
        return getStudentId().equals(that.getStudentId()) && getCourseId().equals(that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getCourseId());
    }
}
