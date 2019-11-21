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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "time_start_task")
    @CreationTimestamp
    private LocalDateTime timeStartTask;

//    private Map<LocalDateTime, LocalDateTime> timeMap;

    @Column(name = "total_time")
    @CreationTimestamp
    private LocalDateTime totalTime;
}
