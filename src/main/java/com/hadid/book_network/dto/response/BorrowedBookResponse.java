package com.hadid.book_network.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BorrowedBookResponse {

    private Long id;

    private String title;

    private String authorName;

    private String isbn;

    private double rate;

    private boolean returned;

    private boolean returnApproved;

}
