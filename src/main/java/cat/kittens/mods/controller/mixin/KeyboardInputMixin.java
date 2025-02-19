package cat.kittens.mods.controller.mixin;

import cat.kittens.mods.controller.ControllerSupport;
import net.minecraft.class_413;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(class_413.class)
public class KeyboardInputMixin {
    @Inject(
            method = "method_1942",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/class_413;field_2536:Z",
                    ordinal = 0,
                    shift = At.Shift.AFTER
            )
    )
    void controller$tick(CallbackInfo ignored) {
        ControllerSupport.INSTANCE.getMovementHandler().tick();
    }
}
