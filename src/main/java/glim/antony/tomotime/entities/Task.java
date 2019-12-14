package glim.antony.tomotime.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "tasks")
@Data
@NoArgsConstructor
public class Task implements Serializable {

    private static final long serialVersionUID = -7612607379234129634L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "time_start_task")
    @CreationTimestamp
    private LocalDateTime timeStartTask;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

//    private Map<LocalDateTime, LocalDateTime> timeMap;

    @Column(name = "total_time")
    @CreationTimestamp
    private LocalDateTime totalTime;

    public enum Status {
        NEW,
        IN_PROCESS,
        PAUSE,
        DONE,
        REJECTED
    }

}
