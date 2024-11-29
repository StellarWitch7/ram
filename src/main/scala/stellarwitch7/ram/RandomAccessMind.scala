package stellarwitch7.ram

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import stellarwitch7.ram.spell.trick.ModTricks

object RandomAccessMind extends ModInitializer {
  val MOD_ID = "ram"
  val LOGGER = LoggerFactory.getLogger(MOD_ID)

  override def onInitialize(): Unit = {
    // This code runs as soon as Minecraft is in a mod-load-ready state.
    // However, some things (like resources) may still be uninitialized.
    // Proceed with mild caution.
    LOGGER.info("SIGSEGV")

    ModTricks.register()
  }
}
