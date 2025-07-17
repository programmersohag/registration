package com.blog.registration.config;

import lombok.Data;

import java.util.List;

@Data
public class ActiveUserStore {
    public List<String> users;
}
