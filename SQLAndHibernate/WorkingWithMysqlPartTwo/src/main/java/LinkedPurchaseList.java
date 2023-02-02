import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey linkedPurchaseListKey;

    @Column(name = "student_id", insertable = false, updatable = false)
    private Integer studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer courseId;

    public LinkedPurchaseList() {
    }

    public LinkedPurchaseList(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.linkedPurchaseListKey = new LinkedPurchaseListKey(studentId, courseId);
    }

    public LinkedPurchaseListKey getlinkedPurchaseListKey() {
        return linkedPurchaseListKey;
    }

    public void setlinkedPurchaseListKey(LinkedPurchaseListKey linkedPurchaseListKey) {
        this.linkedPurchaseListKey = linkedPurchaseListKey;
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
        if (!(o instanceof LinkedPurchaseList that)) return false;
        return getStudentId().equals(that.getStudentId()) && getCourseId().equals(that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getCourseId());
    }
}
