package com.example.splitwiseJul23Beginner.controllers;

import com.example.splitwiseJul23Beginner.dtos.SettleUpGroupRequestDto;
import com.example.splitwiseJul23Beginner.dtos.SettleUserRequestDto;
import com.example.splitwiseJul23Beginner.models.Transaction;
import com.example.splitwiseJul23Beginner.services.SettleUpService;

import java.util.List;

public class SettleUpController {
    private final SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    // /settle/user/{{user_id}}
    public List<Transaction> settlerUser(SettleUserRequestDto dto){
        return settleUpService.settleUser(dto.getUserId());
    }

    // /settle/user/{{group_id}}
    public List<Transaction> settlerGroup(SettleUpGroupRequestDto dto){
        return settleUpService.settleGroup(dto.getGroupId());
    }
}
