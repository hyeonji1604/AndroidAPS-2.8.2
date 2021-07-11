package info.nightscout.androidaps.plugins.pump.omnipod.dash.ui.wizard.deactivation.viewmodel.action

import androidx.annotation.StringRes
import dagger.android.HasAndroidInjector
import info.nightscout.androidaps.data.PumpEnactResult
import info.nightscout.androidaps.interfaces.CommandQueueProvider
import info.nightscout.androidaps.logging.AAPSLogger
import info.nightscout.androidaps.plugins.pump.omnipod.common.R
import info.nightscout.androidaps.plugins.pump.omnipod.common.queue.command.CommandDeactivatePod
import info.nightscout.androidaps.plugins.pump.omnipod.common.ui.wizard.deactivation.viewmodel.action.DeactivatePodViewModel
import info.nightscout.androidaps.plugins.pump.omnipod.dash.driver.pod.state.OmnipodDashPodStateManager
import info.nightscout.androidaps.queue.Callback
import io.reactivex.Single
import javax.inject.Inject

class DashDeactivatePodViewModel @Inject constructor(
    private val podStateManager: OmnipodDashPodStateManager,
    private val commandQueueProvider: CommandQueueProvider,
    injector: HasAndroidInjector,
    logger: AAPSLogger
) : DeactivatePodViewModel(injector, logger) {

    override fun doExecuteAction(): Single<PumpEnactResult> = Single.create { source ->
        commandQueueProvider.customCommand(
            CommandDeactivatePod(),
            object : Callback() {
                override fun run() {
                    source.onSuccess(result)
                }
            }
        )
    }

    override fun discardPod() {
        podStateManager.reset()
    }

    @StringRes
    override fun getTitleId(): Int = R.string.omnipod_common_pod_deactivation_wizard_deactivating_pod_title

    @StringRes
    override fun getTextId(): Int = R.string.omnipod_common_pod_deactivation_wizard_deactivating_pod_text
}