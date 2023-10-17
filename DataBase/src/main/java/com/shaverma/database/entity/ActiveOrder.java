package com.shaverma.database.entity;

import com.shaverma.database.entity.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ActiveOrder")
public class ActiveOrder extends Order {

}
