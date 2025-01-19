package com.hadid.book_network.entity.history;

import com.hadid.book_network.entity.common.BaseEntity;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Email
public class BookTransactionHistory extends BaseEntity {

    private boolean returned;

    private boolean returnApproved;

}
