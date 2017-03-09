package me.sonico.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by yanfa_4 on 2016-11-19.
 */
@Service
public class Constant {
    @Value("${FORTEST}")
    public String fortest;

}
