package stellarwitch7.ram

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import stellarwitch7.ram.spell.trick.ModTricks

object RandomAccessMind : ModInitializer {
	const val MOD_ID: String = "ram"
	val logger: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("SIGSEGV")

		ModTricks.register()
	}
}