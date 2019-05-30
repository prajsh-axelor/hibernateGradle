package TablesFromEntityClasses;

import java.util.Date;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "timekeeper")
public class TimeKeeper {
  public static final char IN = 'I';
  public static final char OUT = 'O';
 
  private String timekeeperId;
 
  private Date dateTime;
 
  private Employee employee;
 
  // 'I' or 'O'
  private char inOut;
 
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @Column(name = "timekeeper_id", length = 36)
  public String getTimekeeperId() {
      return timekeeperId;
  }
 
  public void setTimekeeperId(String timekeeperId) {
      this.timekeeperId = timekeeperId;
  }
 
  @Column(name = "date_time", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  public Date getDateTime() {
      return dateTime;
  }
 
  public void setDateTime(Date dateTime) {
      this.dateTime = dateTime;
  }
 
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "EMP_ID", nullable = false)
  public Employee getEmployee() {
      return employee;
  }
 
  public void setEmployee(Employee employee) {
      this.employee = employee;
  }
 
  @Column(name = "in_out", nullable = false, length = 1)
  public char getInOut() {
      return inOut;
  }
 
  public void setInOut(char inOut) {
      this.inOut = inOut;
  }
 
}
