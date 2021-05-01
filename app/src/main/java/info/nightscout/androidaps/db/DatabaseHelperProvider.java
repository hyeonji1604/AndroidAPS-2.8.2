package info.nightscout.androidaps.db;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.j256.ormlite.dao.CloseableIterator;

import org.json.JSONObject;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import info.nightscout.androidaps.MainApp;
import info.nightscout.androidaps.interfaces.DatabaseHelperInterface;

@Deprecated
@Singleton
public class DatabaseHelperProvider implements DatabaseHelperInterface {

    @Inject DatabaseHelperProvider() {
    }

    @Override public void createOrUpdate(@NonNull DanaRHistoryRecord record) {
        MainApp.Companion.getDbHelper().createOrUpdate(record);
    }

    @Override public void createOrUpdate(@NonNull OmnipodHistoryRecord record) {
        MainApp.Companion.getDbHelper().createOrUpdate(record);
    }

    @NonNull @Override public List<DanaRHistoryRecord> getDanaRHistoryRecordsByType(byte type) {
        return MainApp.Companion.getDbHelper().getDanaRHistoryRecordsByType(type);
    }

    @Override public long size(@NonNull String table) {
        return MainApp.Companion.getDbHelper().size(table);
    }

    @Override public void create(@NonNull DbRequest record) {
        try {
            MainApp.Companion.getDbHelper().create(record);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override public void deleteAllDbRequests() {
        MainApp.Companion.getDbHelper().deleteAllDbRequests();
    }

    @Override public int deleteDbRequest(@NonNull String id) {
        return MainApp.Companion.getDbHelper().deleteDbRequest(id);
    }

    @Override public void deleteDbRequestbyMongoId(@NonNull String action, @NonNull String _id) {
        MainApp.Companion.getDbHelper().deleteDbRequestbyMongoId(action, _id);
    }

    @NonNull @Override public CloseableIterator<DbRequest> getDbRequestIterator() {
        return MainApp.Companion.getDbHelper().getDbRequestIterator();
    }

    @Override public long roundDateToSec(long date) {
        return MainApp.Companion.getDbHelper().roundDateToSec(date);
    }

    @Override public boolean createOrUpdate(@NonNull TemporaryBasal tempBasal) {
        return MainApp.Companion.getDbHelper().createOrUpdate(tempBasal);
    }

    @Nullable @Override public TemporaryBasal findTempBasalByPumpId(long id) {
        return MainApp.Companion.getDbHelper().findTempBasalByPumpId(id);
    }

    @Deprecated
    @NonNull @Override public List<TemporaryBasal> getTemporaryBasalsDataFromTime(long mills, boolean ascending) {
        return MainApp.Companion.getDbHelper().getTemporaryBasalsDataFromTime(mills, ascending);
    }

    @NonNull @Override public List<OmnipodHistoryRecord> getAllOmnipodHistoryRecordsFromTimestamp(long timestamp, boolean ascending) {
        return MainApp.Companion.getDbHelper().getAllOmnipodHistoryRecordsFromTimeStamp(timestamp, ascending);
    }

    @Nullable @Override public OmnipodHistoryRecord findOmnipodHistoryRecordByPumpId(long pumpId) {
        return MainApp.Companion.getDbHelper().findOmnipodHistoryRecordByPumpId(pumpId);
    }

    @Override public void createOrUpdate(@NonNull InsightBolusID record) {
        MainApp.Companion.getDbHelper().createOrUpdate(record);
    }

    @Override public void createOrUpdate(@NonNull InsightPumpID record) {
        MainApp.Companion.getDbHelper().createOrUpdate(record);
    }

    @Override public void createOrUpdate(@NonNull InsightHistoryOffset record) {
        MainApp.Companion.getDbHelper().createOrUpdate(record);
    }

    @Override public void delete(@NonNull ExtendedBolus extendedBolus) {
        MainApp.Companion.getDbHelper().delete(extendedBolus);
    }

    @Nullable @Override public ExtendedBolus getExtendedBolusByPumpId(long pumpId) {
        return MainApp.Companion.getDbHelper().getExtendedBolusByPumpId(pumpId);
    }

    @Nullable @Override public InsightBolusID getInsightBolusID(@NonNull String pumpSerial, int bolusID, long timestamp) {
        return MainApp.Companion.getDbHelper().getInsightBolusID(pumpSerial, bolusID, timestamp);
    }

    @Nullable @Override public InsightHistoryOffset getInsightHistoryOffset(@NonNull String pumpSerial) {
        return MainApp.Companion.getDbHelper().getInsightHistoryOffset(pumpSerial);
    }

    @Nullable @Override public InsightPumpID getPumpStoppedEvent(@NonNull String pumpSerial, long before) {
        return MainApp.Companion.getDbHelper().getPumpStoppedEvent(pumpSerial, before);
    }

    @Override public void resetDatabases() {
        MainApp.Companion.getDbHelper().resetDatabases();
    }

    @Override public void createOrUpdate(@NonNull OHQueueItem record) {
        MainApp.Companion.getDbHelper().createOrUpdate(record);
    }

    @NonNull @Override public List<OHQueueItem> getAllOHQueueItems(long maxEntries) {
        return MainApp.Companion.getDbHelper().getAllOHQueueItems(maxEntries);
    }

    @Override public long getOHQueueSize() {
        return MainApp.Companion.getDbHelper().getOHQueueSize();
    }

    @Override public void clearOpenHumansQueue() {
        MainApp.Companion.getDbHelper().clearOpenHumansQueue();
    }

    @Override public long getCountOfAllRows() {
        return MainApp.Companion.getDbHelper().getCountOfAllRows();
    }

    @Override public void removeAllOHQueueItemsWithIdSmallerThan(long id) {
        MainApp.Companion.getDbHelper().removeAllOHQueueItemsWithIdSmallerThan(id);
    }
}
