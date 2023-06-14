package org.example.api.service;

import org.example.api.service.dto.BankInfo;

public interface DemoService {

    String sayHello(String name);

    BankInfo getBankInfo(String name);

}
