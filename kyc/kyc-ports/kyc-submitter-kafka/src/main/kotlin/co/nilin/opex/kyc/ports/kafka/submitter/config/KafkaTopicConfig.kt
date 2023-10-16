package co.nilin.opex.kyc.ports.kafka.submitter.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.GenericApplicationContext
import org.springframework.kafka.config.TopicBuilder
import java.util.function.Supplier

@Configuration
class KafkaTopicConfig {

    @Autowired
    fun createTopics(applicationContext: GenericApplicationContext) {
        applicationContext.registerBean("topic_kyc_level_updated", NewTopic::class.java, Supplier {
            TopicBuilder.name("kyc_level_updated")
                    .partitions(1)
                    .replicas(1)
                    .build()
        })
    }

}