package glim.antony.tomotime.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

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

    private LocalDateTime timeStartTask;

    private Map<LocalDateTime, LocalDateTime> timeMap;

    @Column(name = "totalTime")
    private LocalDateTime totalTime;
}
