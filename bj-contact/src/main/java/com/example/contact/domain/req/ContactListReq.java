package com.example.contact.domain.req;

import com.example.contact.domain.base.BaseReq;
import lombok.Data;

@Data
public class ContactListReq extends BaseReq {
    String name;
}
