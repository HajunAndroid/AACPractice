package kr.co.hajun.aacpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import kr.co.hajun.aacpractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CardUsageViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(CardUsageViewModel.class);
        model.cardUsageList.observe(this, new Observer<List<CardUsage>>() {
            @Override
            public void onChanged(List<CardUsage> cardUsages) {
                updateCardUsageList(cardUsages);
            }
        });
    }

    private void updateCardUsageList(List<CardUsage> cardUsages){
        int sum = 0;
        for(CardUsage cardUsage : cardUsages){
            sum+=cardUsage.price;
        }
        DecimalFormat df = new DecimalFormat("###,###");
        binding.spendCache.setText(df.format(sum));
    }

    public void addCardUsage(View view){
        CardUsage cardUsage = new CardUsage();
        cardUsage.date = binding.spendWhen.getText().toString();
        cardUsage.store = binding.spendWhere.getText().toString();
        cardUsage.price = Integer.parseInt(binding.spendHowMuch.getText().toString());
        model.insert(cardUsage);
    }

    public void selectDay(View view){
        Calendar calendar = Calendar.getInstance();
        final int[] nYear = {calendar.get(Calendar.YEAR)};
        final int[] nMonth = {calendar.get(Calendar.MONTH) + 1};
        final int[] nDay = {calendar.get(Calendar.DAY_OF_MONTH)};
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                nYear[0] = i;
                nMonth[0] = i1+1;
                nDay[0] = i2;
                binding.spendWhen.setText(nYear[0] +"."+ nMonth[0] +"."+ nDay[0]);
            }
        }, nYear[0], nMonth[0] -1, nDay[0]);
        datePickerDialog.show();
    }
}