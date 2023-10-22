package com.shaverma.database.entity;

import com.shaverma.database.entity.user.AllUser;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "WebUser")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String comment;
    @ManyToOne
    @JoinColumn(name = "user")
    private AllUser user;

}
