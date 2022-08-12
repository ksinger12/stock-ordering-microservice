package com.trading.trader;

import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.forex.Forex;
import com.crazzyghost.alphavantage.parameters.Interval;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.TimeSeries;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TraderApplicationTests {

	@Test
	void contextLoads() {
		Config cfg = Config.builder()
				.key("RBJRR2YCUMFQRRKZ")
				.timeOut(10)
				.build();

		AlphaVantage.api().init(cfg);

		TimeSeriesResponse response = AlphaVantage.api()
				.timeSeries()
				.intraday()
				.forSymbol("IBM")
				.interval(Interval.FIVE_MIN)
				.outputSize(OutputSize.FULL)
				.fetchSync();
		// AlphaVantage.api().fundamentalData().companyOverview().forSymbol("IBM").fetchSync(); // use for stock info
		// AlphaVantage.api().sector().fetchSync() // use for sector info
	}

}
