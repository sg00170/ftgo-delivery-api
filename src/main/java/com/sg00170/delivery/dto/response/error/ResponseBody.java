package com.sg00170.delivery.dto.response.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBody {
    private Map<String, ResponseMessage> errors;
}
