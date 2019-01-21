package org.lanqiao.project.pojo;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Condition {

    private Integer u_id;
    private String u_name;
    private String u_nickname;
    private Integer currentPage;
    private Integer pageSize;
}
