google.charts.load('current', {
  'packages': ['corechart']
});

google.charts.setOnLoadCallback(drawChart);
google.charts.setOnLoadCallback(drawChart2);
google.charts.setOnLoadCallback(drawChart3);
google.charts.setOnLoadCallback(drawChart4);
google.charts.setOnLoadCallback(drawChart5);
google.charts.setOnLoadCallback(drawStuff);



function drawChart() {
  

  var data = google.visualization.arrayToDataTable([
 
    ["datatime", "media"],

    ["2022-01-01", 11.612499952316284],
    ["2022-01-02", 11.069565151048744],
    ["2022-01-03", 11.069565151048744],
    ["2022-01-04", 11.069565151048744],
    ["2022-01-05", 11.069565151048744],
    ["2022-01-06", 11.069565151048744],
    ["2022-01-07", 11.069565151048744],
    ["2022-01-08", 11.069565151048744],
    ["2022-01-09", 11.069565151048744],
    ["2022-01-10", 11.069565151048744],
    ["2022-01-11", 11.069565151048744],
    ["2022-01-12", 11.069565151048744],
    ["2022-01-13", 11.069565151048744],
    ["2022-01-14", 11.069565151048744],
    ["2022-01-15", 11.069565151048744],
    ["2022-01-16", 11.069565151048744],
    ["2022-01-17", 11.069565151048744],
    ["2022-01-18", 11.069565151048744],
    ["2022-01-19", 11.069565151048744],
    ["2022-01-20", 11.069565151048744],
    ["2022-01-21", 11.069565151048744],
    ["2022-01-22", 11.069565151048744],
    ["2022-01-23", 11.069565151048744],
    ["2022-01-24", 11.069565151048744],
    ["2022-01-25", 11.069565151048744],
    ["2022-01-26", 11.069565151048744],
    ["2022-01-27", 11.069565151048744],
    ["2022-01-28", 10.964999961853028],
    ["2022-01-29", 11.069565151048744],
    ["2022-01-30", 11.069565151048744],
    ["2022-01-31", 11.069565151048744],
    ["2022-02-01", 11.069565151048744],
    ["2022-02-02", 11.069565151048744],
    ["2022-02-03", 11.069565151048744],
    ["2022-02-04", 11.069565151048744],
    ["2022-02-05", 11.069565151048744],
    ["2022-02-06", 11.069565151048744],
    ["2022-02-07", 11.069565151048744],
    ["2022-02-08", 11.069565151048744],
    ["2022-02-09", 11.069565151048744],
    ["2022-02-10", 11.069565151048744],
    ["2022-02-11", 11.069565151048744],
    ["2022-02-12", 11.069565151048744],
    ["2022-02-13", 10.92941171982709],
    ["2022-02-14", 11.612499952316284],
    ["2022-04-05", 11.612499952316284],
    ["2022-04-06", 11.069565151048744],
    ["2022-04-07", 11.069565151048744],
    ["2022-04-08", 11.069565151048744],
    ["2022-04-09", 11.069565151048744],
    ["2022-04-10", 11.069565151048744],
    ["2022-04-11", 11.069565151048744],
    ["2022-04-12", 11.069565151048744],
    ["2022-04-13", 11.069565151048744],
    ["2022-04-14", 11.069565151048744],
    ["2022-04-15", 11.069565151048744],
    ["2022-04-16", 11.069565151048744],
    ["2022-04-17", 11.069565151048744],
    ["2022-04-18", 11.069565151048744],
    ["2022-04-19", 11.069565151048744],
    ["2022-04-20", 11.069565151048744],
    ["2022-04-21", 11.069565151048744],
    ["2022-04-22", 11.069565151048744],
    ["2022-04-23", 11.069565151048744],
    ["2022-04-24", 11.069565151048744],
    ["2022-04-25", 11.069565151048744],
    ["2022-04-26", 11.069565151048744],
    ["2022-04-27", 11.069565151048744],
    ["2022-04-28", 11.069565151048744],
    ["2022-04-29", 11.069565151048744],
    ["2022-04-30", 11.379999923706055],
    ["2022-05-01", 11.069565151048744],
    ["2022-05-02", 11.069565151048744],
    ["2022-05-03", 11.069565151048744],
    ["2022-05-04", 11.069565151048744],
    ["2022-05-05", 11.069565151048744],
    ["2022-05-06", 11.208333253860474],
    ["2022-05-07", 11.069565151048744],
    ["2022-05-08", 11.069565151048744],
    ["2022-05-09", 11.069565151048744],
    ["2022-05-10", 11.069565151048744],
    ["2022-05-11", 11.013333257039388],
    ["2022-05-12", 11.069565151048744],
    ["2022-05-13", 11.069565151048744],
    ["2022-05-14", 11.069565151048744],
    ["2022-05-15", 11.069565151048744],
    ["2022-05-16", 11.069565151048744],
    ["2022-05-17", 11.069565151048744],
    ["2022-05-18", 11.069565151048744],
    ["2022-05-19", 11.699999945504326],
  ]);


  var options = {
    title: 'Grafico valori temperatura',
    curveType: 'function',


    legend: {
      position: 'bottom',

    },
    vAxis: {
      title: 'Valori (scale of 1-10)'

    },
    hAxis: {
      title: 'Media giornaliera',
      format: 'h:mm a',
      viewWindow: {
        min: [7, 30, 0],
        max: [17, 30, 0]
      }

  }

  }

  var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

  chart.draw(data, options);
}

function drawChart2() {
  var data2 = google.visualization.arrayToDataTable([
    ["datatime", "media"],
    ["2022-01-01", 15.428571428571429],
    ["2022-01-02", 14.304347826086957],
    ["2022-01-03", 14.5],
    ["2022-01-04", 14.5],
    ["2022-01-05", 14.5],
    ["2022-01-06", 14.5],
    ["2022-01-07", 14.304347826086957],
    ["2022-01-08", 14.5],
    ["2022-01-09", 14.5],
    ["2022-01-10", 14.5],
    ["2022-01-11", 14.5],
    ["2022-01-12", 14.304347826086957],
    ["2022-01-13", 14.5],
    ["2022-01-14", 14.5],
    ["2022-01-15", 14.5],
    ["2022-01-16", 14.5],
    ["2022-01-17", 14.304347826086957],
    ["2022-01-18", 14.5],
    ["2022-01-19", 14.5],
    ["2022-01-20", 14.5],
    ["2022-01-21", 14.304347826086957],
    ["2022-01-22", 14.304347826086957],
    ["2022-01-23", 14.5],
    ["2022-01-24", 14.5],
    ["2022-01-25", 14.5],
    ["2022-01-26", 14.304347826086957],
    ["2022-01-27", 14.304347826086957],
    ["2022-01-28", 13.761904761904763],
    ["2022-01-29", 14.5],
    ["2022-01-30", 14.5],
    ["2022-01-31", 14.304347826086957],
    ["2022-02-01", 14.5],
    ["2022-02-02", 14.5],
    ["2022-02-03", 14.5],
    ["2022-02-04", 14.5],
    ["2022-02-05", 14.304347826086957],
    ["2022-02-06", 14.5],
    ["2022-02-07", 14.5],
    ["2022-02-08", 14.5],
    ["2022-02-09", 14.304347826086957],
    ["2022-02-10", 14.304347826086957],
    ["2022-02-11", 14.304347826086957],
    ["2022-02-12", 14.5],
    ["2022-02-13", 13.38888888888889],
    ["2022-02-14", 15.428571428571429],
    ["2022-04-05", 15.428571428571429],
    ["2022-04-06", 14.5],
    ["2022-04-07", 14.304347826086957],
    ["2022-04-08", 14.304347826086957],
    ["2022-04-09", 14.5],
    ["2022-04-10", 14.5],
    ["2022-04-11", 14.5],
    ["2022-04-12", 14.5],
    ["2022-04-13", 14.5],
    ["2022-04-14", 14.304347826086957],
    ["2022-04-15", 14.5],
    ["2022-04-16", 14.5],
    ["2022-04-17", 14.5],
    ["2022-04-18", 14.5],
    ["2022-04-19", 14.5],
    ["2022-04-20", 14.304347826086957],
    ["2022-04-21", 14.5],
    ["2022-04-22", 14.5],
    ["2022-04-23", 14.5],
    ["2022-04-24", 14.5],
    ["2022-04-25", 14.5],
    ["2022-04-26", 14.5],
    ["2022-04-27", 14.304347826086957],
    ["2022-04-28", 14.5],
    ["2022-04-29", 14.5],
    ["2022-04-30", 14.0],
    ["2022-05-01", 14.5],
    ["2022-05-02", 14.5],
    ["2022-05-03", 14.304347826086957],
    ["2022-05-04", 14.304347826086957],
    ["2022-05-05", 14.5],
    ["2022-05-06", 13.833333333333334],
    ["2022-05-07", 14.5],
    ["2022-05-08", 14.5],
    ["2022-05-09", 14.5],
    ["2022-05-10", 14.304347826086957],
    ["2022-05-11", 13.4375],
    ["2022-05-12", 14.5],
    ["2022-05-13", 14.5],
    ["2022-05-14", 14.5],
    ["2022-05-15", 14.5],
    ["2022-05-16", 14.304347826086957],
    ["2022-05-17", 14.304347826086957],
    ["2022-05-18", 14.5],
    ["2022-05-19", 15.833333333333334],



  ])
  var options2 = {
    title: 'Grafico valori PM10',
    curveType: 'function',
    legend: {
      position: 'bottom',

    },
    vAxis: {
      title: 'Valori (scale of 1-10)'

    },
    hAxis: {
      title: 'Media giornaliera',
      format: 'h:mm a',
      viewWindow: {
        min: [7, 30, 0],
        max: [17, 30, 0]
      }

  }





  };

  var chart1 = new google.visualization.LineChart(document.getElementById('curve_chart1'));

  chart1.draw(data2, options2);
}

function drawChart3() {
  var data3 = google.visualization.arrayToDataTable([
    ["datatime", "media"],
    ["2022-01-01", 12.5],
    ["2022-01-02", 11.956521739130435],
    ["2022-01-03", 12.041666666666666],
    ["2022-01-04", 12.041666666666666],
    ["2022-01-05", 12.041666666666666],
    ["2022-01-06", 12.041666666666666],
    ["2022-01-07", 11.956521739130435],
    ["2022-01-08", 12.041666666666666],
    ["2022-01-09", 12.041666666666666],
    ["2022-01-10", 12.041666666666666],
    ["2022-01-11", 12.041666666666666],
    ["2022-01-12", 11.956521739130435],
    ["2022-01-13", 12.041666666666666],
    ["2022-01-14", 12.041666666666666],
    ["2022-01-15", 12.041666666666666],
    ["2022-01-16", 12.041666666666666],
    ["2022-01-17", 11.956521739130435],
    ["2022-01-18", 12.041666666666666],
    ["2022-01-19", 12.041666666666666],
    ["2022-01-20", 12.041666666666666],
    ["2022-01-21", 11.956521739130435],
    ["2022-01-22", 11.956521739130435],
    ["2022-01-23", 12.041666666666666],
    ["2022-01-24", 12.041666666666666],
    ["2022-01-25", 12.041666666666666],
    ["2022-01-26", 11.956521739130435],
    ["2022-01-27", 11.956521739130435],
    ["2022-01-28", 11.571428571428571],
    ["2022-01-29", 12.041666666666666],
    ["2022-01-30", 12.041666666666666],
    ["2022-01-31", 11.956521739130435],
    ["2022-02-01", 12.041666666666666],
    ["2022-02-02", 12.041666666666666],
    ["2022-02-03", 12.041666666666666],
    ["2022-02-04", 12.041666666666666],
    ["2022-02-05", 11.956521739130435],
    ["2022-02-06", 12.041666666666666],
    ["2022-02-07", 12.041666666666666],
    ["2022-02-08", 12.041666666666666],
    ["2022-02-09", 11.956521739130435],
    ["2022-02-10", 11.956521739130435],
    ["2022-02-11", 11.956521739130435],
    ["2022-02-12", 12.041666666666666],
    ["2022-02-13", 11.333333333333334],
    ["2022-02-14", 12.5],
    ["2022-04-05", 12.5],
    ["2022-04-06", 12.041666666666666],
    ["2022-04-07", 11.956521739130435],
    ["2022-04-08", 11.956521739130435],
    ["2022-04-09", 12.041666666666666],
    ["2022-04-10", 12.041666666666666],
    ["2022-04-11", 12.041666666666666],
    ["2022-04-12", 12.041666666666666],
    ["2022-04-13", 12.041666666666666],
    ["2022-04-14", 11.956521739130435],
    ["2022-04-15", 12.041666666666666],
    ["2022-04-16", 12.041666666666666],
    ["2022-04-17", 12.041666666666666],
    ["2022-04-18", 12.041666666666666],
    ["2022-04-19", 12.041666666666666],
    ["2022-04-20", 11.956521739130435],
    ["2022-04-21", 12.041666666666666],
    ["2022-04-22", 12.041666666666666],
    ["2022-04-23", 12.041666666666666],
    ["2022-04-24", 12.041666666666666],
    ["2022-04-25", 12.041666666666666],
    ["2022-04-26", 12.041666666666666],
    ["2022-04-27", 11.956521739130435],
    ["2022-04-28", 12.041666666666666],
    ["2022-04-29", 12.041666666666666],
    ["2022-04-30", 11.727272727272727],
    ["2022-05-01", 12.041666666666666],
    ["2022-05-02", 12.041666666666666],
    ["2022-05-03", 11.956521739130435],
    ["2022-05-04", 11.956521739130435],
    ["2022-05-05", 12.041666666666666],
    ["2022-05-06", 11.727272727272727],
    ["2022-05-07", 12.041666666666666],
    ["2022-05-08", 12.041666666666666],
    ["2022-05-09", 12.041666666666666],
    ["2022-05-10", 11.956521739130435],
    ["2022-05-11", 11.3125],
    ["2022-05-12", 12.041666666666666],
    ["2022-05-13", 12.041666666666666],
    ["2022-05-14", 12.041666666666666],
    ["2022-05-15", 12.041666666666666],
    ["2022-05-16", 11.956521739130435],
    ["2022-05-17", 11.956521739130435],
    ["2022-05-18", 12.041666666666666],
    ["2022-05-19", 12.857142857142858],




  ])
  var options3 = {
    title: 'Grafico valori sensore PM2.5',
    curveType: 'function',
    legend: {
      position: 'bottom',


    },
    vAxis: {
      title: 'Valori (scale of 1-10)'

    },
    hAxis: {
      title: 'Media giornaliera',
      format: 'h:mm a',
      viewWindow: {
        min: [7, 30, 0],
        max: [17, 30, 0]
      }
  }
}

  var chart3 = new google.visualization.LineChart(document.getElementById('curve_chart3'));

  chart3.draw(data3, options3);
}

function drawChart4() {
  var data4 = google.visualization.arrayToDataTable([
    ["datatime", "media"],
    ["2022-01-01", 99.9000015258789],
    ["2022-01-02", 99.88636502352628],
    ["2022-01-03", 99.88750139872234],
    ["2022-01-04", 99.88750139872234],
    ["2022-01-05", 99.88750139872234],
    ["2022-01-06", 99.88750139872234],
    ["2022-01-07", 99.88636502352628],
    ["2022-01-08", 99.88750139872234],
    ["2022-01-09", 99.88750139872234],
    ["2022-01-10", 99.88750139872234],
    ["2022-01-11", 99.88750139872234],
    ["2022-01-12", 99.88636502352628],
    ["2022-01-13", 99.88750139872234],
    ["2022-01-14", 99.88750139872234],
    ["2022-01-15", 99.88750139872234],
    ["2022-01-16", 99.88750139872234],
    ["2022-01-17", 99.88636502352628],
    ["2022-01-18", 99.88750139872234],
    ["2022-01-19", 99.88750139872234],
    ["2022-01-20", 99.88750139872234],
    ["2022-01-21", 99.88636502352628],
    ["2022-01-22", 99.88636502352628],
    ["2022-01-23", 99.88750139872234],
    ["2022-01-24", 99.88750139872234],
    ["2022-01-25", 99.88750139872234],
    ["2022-01-26", 99.88636502352628],
    ["2022-01-27", 99.88636502352628],
    ["2022-01-28", 99.8857156662714],
    ["2022-01-29", 99.88750139872234],
    ["2022-01-30", 99.88750139872234],
    ["2022-01-31", 99.88636502352628],
    ["2022-02-01", 99.88750139872234],
    ["2022-02-02", 99.88750139872234],
    ["2022-02-03", 99.88750139872234],
    ["2022-02-04", 99.88750139872234],
    ["2022-02-05", 99.88636502352628],
    ["2022-02-06", 99.88750139872234],
    ["2022-02-07", 99.88750139872234],
    ["2022-02-08", 99.88750139872234],
    ["2022-02-09", 99.88636502352628],
    ["2022-02-10", 99.88636502352628],
    ["2022-02-11", 99.88636502352628],
    ["2022-02-12", 99.88750139872234],
    ["2022-02-13", 99.88333468967014],
    ["2022-02-14", 99.9000015258789],
    ["2022-04-05", 99.9000015258789],
    ["2022-04-06", 99.88750139872234],
    ["2022-04-07", 99.88636502352628],
    ["2022-04-08", 99.88636502352628],
    ["2022-04-09", 99.88750139872234],
    ["2022-04-10", 99.88750139872234],
    ["2022-04-11", 99.88750139872234],
    ["2022-04-12", 99.88750139872234],
    ["2022-04-13", 99.88750139872234],
    ["2022-04-14", 99.88636502352628],
    ["2022-04-15", 99.88750139872234],
    ["2022-04-16", 99.88750139872234],
    ["2022-04-17", 99.88750139872234],
    ["2022-04-18", 99.88750139872234],
    ["2022-04-19", 99.88750139872234],
    ["2022-04-20", 99.88636502352628],
    ["2022-04-21", 99.88750139872234],
    ["2022-04-22", 99.88750139872234],
    ["2022-04-23", 99.88750139872234],
    ["2022-04-24", 99.88750139872234],
    ["2022-04-25", 99.88750139872234],
    ["2022-04-26", 99.88750139872234],
    ["2022-04-27", 99.88636502352628],
    ["2022-04-28", 99.88750139872234],
    ["2022-04-29", 99.88750139872234],
    ["2022-04-30", 99.87272852117366],
    ["2022-05-01", 99.88750139872234],
    ["2022-05-02", 99.88750139872234],
    ["2022-05-03", 99.88636502352628],
    ["2022-05-04", 99.88636502352628],
    ["2022-05-05", 99.88750139872234],
    ["2022-05-06", 99.87500127156575],
    ["2022-05-07", 99.88750139872234],
    ["2022-05-08", 99.88750139872234],
    ["2022-05-09", 99.88750139872234],
    ["2022-05-10", 99.88636502352628],
    ["2022-05-11", 99.88125133514404],
    ["2022-05-12", 99.88750139872234],
    ["2022-05-13", 99.88750139872234],
    ["2022-05-14", 99.88750139872234],
    ["2022-05-15", 99.88750139872234],
    ["2022-05-16", 99.88636502352628],
    ["2022-05-17", 99.88636502352628],
    ["2022-05-18", 99.88750139872234],
    ["2022-05-19", 99.9000015258789],



  ])
  var options4 = {
    title: 'Grafico valori umidità',
    curveType: 'function',
    legend: {
      position: 'bottom',

    },
    vAxis: {
      title: 'Valori (scale of 10-90)'

    },
    hAxis: {
      title: 'Media giornaliera',
      format: 'h:mm a',
      viewWindow: {
        min: [7, 30, 0],
        max: [17, 30, 0]
      }
  }


  };

  var chart4 = new google.visualization.LineChart(document.getElementById('curve_chart4'));

  chart4.draw(data4, options4);
}




function drawStuff() {
  var data = new google.visualization.DataTable();
  data.addColumn('string', 'Sensore');
  data.addColumn('number', 'Giorni');
  data.addRows([

    ['RH', 4],
    ['T', 6],
    ['PM2.5', 4],
    ['PM10', 4]
  ]);

  var options = {
    title: 'Giorni nella quale è stato superato il limite di riferimento',

    legend: 'none',
    bar: {
      groupWidth: '95%'
    },
    vAxis: {
      gridlines: {
        count: 4
      }
    }
  };

  var chart = new google.visualization.ColumnChart(document.getElementById('number_format_chart'));
  chart.draw(data, options);

  document.getElementById('format-select').onchange = function () {
    options['vAxis']['format'] = this.value;
    chart.draw(data, options);
  };
};

function drawChart5() {
  var data5 = google.visualization.arrayToDataTable([
    ["Giorno", "media temperatura", "media umidità"],
    ["", 0, 0],
    ["2022-01-01", 11.612499952316284, 99.9000015258789],
    ["2022-01-02", 11.069565151048744, 99.88636502352628],
    ["2022-01-03", 11.069565151048744, 99.88750139872234],
    ["2022-01-04", 11.069565151048744, 99.88750139872234],
    ["2022-01-05", 11.069565151048744, 99.88750139872234],
    ["2022-01-06", 11.069565151048744, 99.88750139872234],
    ["2022-01-07", 11.069565151048744, 99.88636502352628],
    ["2022-01-08", 11.069565151048744, 99.88750139872234],
    ["2022-01-09", 11.069565151048744, 99.88750139872234],
    ["2022-01-10", 11.069565151048744, 99.88750139872234],
    ["2022-01-11", 11.069565151048744, 99.88750139872234],
    ["2022-01-12", 11.069565151048744, 99.88636502352628],
    ["2022-01-13", 11.069565151048744, 99.88750139872234],
    ["2022-01-14", 11.069565151048744, 99.88750139872234],
    ["2022-01-15", 11.069565151048744, 99.88750139872234],
    ["2022-01-16", 11.069565151048744, 99.88750139872234],
    ["2022-01-17", 11.069565151048744, 99.88636502352628],
    ["2022-01-18", 11.069565151048744, 99.88750139872234],
    ["2022-01-19", 11.069565151048744, 99.88750139872234],
    ["2022-01-20", 11.069565151048744, 99.88750139872234],
    ["2022-01-21", 11.069565151048744, 99.88636502352628],
    ["2022-01-22", 11.069565151048744, 99.88636502352628],
    ["2022-01-23", 11.069565151048744, 99.88750139872234],
    ["2022-01-24", 11.069565151048744, 99.88750139872234],
    ["2022-01-25", 11.069565151048744, 99.88750139872234],
    ["2022-01-26", 11.069565151048744, 99.88636502352628],
    ["2022-01-27", 11.069565151048744, 99.88636502352628],
    ["2022-01-28", 10.964999961853028, 99.8857156662714],
    ["2022-01-29", 11.069565151048744, 99.88750139872234],
    ["2022-01-30", 11.069565151048744, 99.88750139872234],
    ["2022-01-31", 11.069565151048744, 99.88636502352628],
    ["2022-02-01", 11.069565151048744, 99.88750139872234],
    ["2022-02-02", 11.069565151048744, 99.88750139872234],
    ["2022-02-03", 11.069565151048744, 99.88750139872234],
    ["2022-02-04", 11.069565151048744, 99.88750139872234],
    ["2022-02-05", 11.069565151048744, 99.88636502352628],
    ["2022-02-06", 11.069565151048744, 99.88750139872234],
    ["2022-02-07", 11.069565151048744, 99.88750139872234],
    ["2022-02-08", 11.069565151048744, 99.88750139872234],
    ["2022-02-09", 11.069565151048744, 99.88636502352628],
    ["2022-02-10", 11.069565151048744, 99.88636502352628],
    ["2022-02-11", 11.069565151048744, 99.88636502352628],
    ["2022-02-12", 11.069565151048744, 99.88750139872234],
    ["2022-02-13", 10.92941171982709, 99.88333468967014],
    ["2022-02-14", 11.612499952316284, 99.9000015258789],
    ["2022-04-05", 11.612499952316284, 99.9000015258789],
    ["2022-04-06", 11.069565151048744, 99.88750139872234],
    ["2022-04-07", 11.069565151048744, 99.88636502352628],
    ["2022-04-08", 11.069565151048744, 99.88636502352628],
    ["2022-04-09", 11.069565151048744, 99.88750139872234],
    ["2022-04-10", 11.069565151048744, 99.88750139872234],
    ["2022-04-11", 11.069565151048744, 99.88750139872234],
    ["2022-04-12", 11.069565151048744, 99.88750139872234],
    ["2022-04-13", 11.069565151048744, 99.88750139872234],
    ["2022-04-14", 11.069565151048744, 99.88636502352628],
    ["2022-04-15", 11.069565151048744, 99.88750139872234],
    ["2022-04-16", 11.069565151048744, 99.88750139872234],
    ["2022-04-17", 11.069565151048744, 99.88750139872234],
    ["2022-04-18", 11.069565151048744, 99.88750139872234],
    ["2022-04-19", 11.069565151048744, 99.88750139872234],
    ["2022-04-20", 11.069565151048744, 99.88636502352628],
    ["2022-04-21", 11.069565151048744, 99.88750139872234],
    ["2022-04-22", 11.069565151048744, 99.88750139872234],
    ["2022-04-23", 11.069565151048744, 99.88750139872234],
    ["2022-04-24", 11.069565151048744, 99.88750139872234],
    ["2022-04-25", 11.069565151048744, 99.88750139872234],
    ["2022-04-26", 11.069565151048744, 99.88750139872234],
    ["2022-04-27", 11.069565151048744, 99.88636502352628],
    ["2022-04-28", 11.069565151048744, 99.88750139872234],
    ["2022-04-29", 11.069565151048744, 99.88750139872234],
    ["2022-04-30", 11.379999923706055, 99.87272852117366],
    ["2022-05-01", 11.069565151048744, 99.88750139872234],
    ["2022-05-02", 11.069565151048744, 99.88750139872234],
    ["2022-05-03", 11.069565151048744, 99.88636502352628],
    ["2022-05-04", 11.069565151048744, 99.88636502352628],
    ["2022-05-05", 11.069565151048744, 99.88750139872234],
    ["2022-05-06", 11.208333253860474, 99.87500127156575],
    ["2022-05-07", 11.069565151048744, 99.88750139872234],
    ["2022-05-08", 11.069565151048744, 99.88750139872234],
    ["2022-05-09", 11.069565151048744, 99.88750139872234],
    ["2022-05-10", 11.069565151048744, 99.88636502352628],
    ["2022-05-11", 11.013333257039388, 99.88125133514404],
    ["2022-05-12", 11.069565151048744, 99.88750139872234],
    ["2022-05-13", 11.069565151048744, 99.88750139872234],
    ["2022-05-14", 11.069565151048744, 99.88750139872234],
    ["2022-05-15", 11.069565151048744, 99.88750139872234],
    ["2022-05-16", 11.069565151048744, 99.88636502352628],
    ["2022-05-17", 11.069565151048744, 99.88636502352628],
    ["2022-05-18", 11.069565151048744, 99.88750139872234],
    ["2022-05-19", 11.699999945504326, 99.9000015258789],






  ])
  var options5 = {
    title: 'Grafico valori umidità',

    curveType: 'function',
    legend: {
      position: 'bottom',


    },
    vAxis: {
      title: 'Valori (scale of 1-100)'

    },
    hAxis: {
      title: 'Media giornaliera',
      format: 'h:mm a',
      viewWindow: {
        min: [7, 30, 0],
        max: [17, 30, 0]
      }
  }


  };

  var chart5 = new google.visualization.LineChart(document.getElementById('curve_chart5'));

  chart5.draw(data5, options5);
}