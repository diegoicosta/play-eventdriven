package stream

import java.util.Properties

import com.google.inject.{AbstractModule, Inject}
import org.apache.kafka.common.serialization.Serdes
import org.apache.kafka.streams.StreamsConfig.{APPLICATION_ID_CONFIG, BOOTSTRAP_SERVERS_CONFIG}
import org.apache.kafka.streams.KafkaStreams
import org.apache.kafka.streams.kstream.KStreamBuilder
import play.api.{Configuration, Environment, Logger}

/**
  * Created by diegoicosta on 22/08/17.
  */
class StreamModule(
                    environment: Environment,
                    configuration: Configuration) extends AbstractModule {

  override def configure(): Unit = {
    Logger.info("Starting stream module ...")

    val settings = new Properties
    settings.put(APPLICATION_ID_CONFIG, "diego-play-scala.app01")
    settings.put(BOOTSTRAP_SERVERS_CONFIG, configuration.underlying.getString("app.broker.url"))


    val serde = new Serdes.StringSerde

    val builder = new KStreamBuilder
    builder.stream(serde, serde, "test.scala")
      .print()


    val streams = new KafkaStreams(builder, settings)

    streams.start()

  }

}
