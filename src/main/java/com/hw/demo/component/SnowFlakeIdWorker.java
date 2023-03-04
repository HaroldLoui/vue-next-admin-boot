package com.hw.demo.component;

import com.baomidou.mybatisplus.core.toolkit.Sequence;
import org.springframework.stereotype.Component;

@Component
public class SnowFlakeIdWorker {

    private final Sequence sequence;

    public SnowFlakeIdWorker() {
        this.sequence = new Sequence(0, 0);
    }

    public Long nextId() {
        return sequence.nextId();
    }
}
