package ru.alex.messages.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "usr")
public class Message {
    @Id
    @SequenceGenerator(name = "message_seq", sequenceName = "message_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
    private Long id;
    private String text;

    @ManyToOne
    private User user;
}
