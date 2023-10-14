package com.chefencasa.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private int idMessage;

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idSender")
    private User sender;

    @ManyToOne (cascade={CascadeType.ALL, CascadeType.REFRESH})
    @JoinColumn (name = "idReceiver")
    private User receiver;

    @Column(name="subject", nullable = false)
    private String subject;

    @Column(name="value", nullable = false)
    private String value;

    @Column(name="response")
    private String response;

    @Column(name="answered")
    private boolean Answered;
}
