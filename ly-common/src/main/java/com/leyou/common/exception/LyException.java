package com.leyou.common.exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LyException extends RuntimeException {

    private ExceptionEnum exceptionEnum;

}
