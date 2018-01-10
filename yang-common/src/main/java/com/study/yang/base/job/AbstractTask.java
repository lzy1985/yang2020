package com.study.yang.base.job;

import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;
import com.study.yang.base.monitor.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;

/**
 * @author lzy
 * @version 1.0.0
 * @date 2017/9/12 上午10:56
 * @Description
 */
@Slf4j
public abstract class AbstractTask extends AbstractOneOffElasticJob {

    /**
     * 执行作业.
     *
     * @param shardingContext 作业分片规则配置上下文
     */
    public void process(JobExecutionMultipleShardingContext shardingContext) {
        String traceId= LogUtil.traceID();
        MDC.put("traceId",traceId);
        // 开始计时
        long start = System.currentTimeMillis();
        try {
            log.info("任务【{}】执行开始！", this.getTaskName());
            // 执行任务
            this.doExecute();
        } catch (Exception e) {
            log.error("任务【{}】执行失败！", this.getTaskName(), e);
        } finally {
            // 结束计时
            long end = System.currentTimeMillis();
            log.info("任务【{}】执行结束！耗时：{}秒", this.getTaskName(),(end - start) / 1000.000);
            MDC.remove(traceId);
        }
    }

    /**
     * 任务名称
     *
     * @return
     */
    public abstract String getTaskName();

    /**
     * 具体执行的任务
     */
    public abstract void doExecute() throws Exception;
}
