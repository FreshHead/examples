import React, { Component } from 'react';
import {Line} from 'react-chartjs-2';
import Chart from 'react-chartjs-2';
import './App.css';

const data = {
    labels: ['January', 'lul', 'February'],
    datasets: [{
        label: 'My First dataset',
        backgroundColor: ['rgba(255,99,132,0.2)', 'rgba(1,250,132,0.2)'],
        borderColor: 'rgba(255,99,132,1)',
        borderWidth: 1,
        hoverBackgroundColor: 'rgba(255,99,132,0.4)',
        hoverBorderColor: 'rgba(255,99,132,1)',
        data: [65, 59, 100, 120, 130, 103]
    }]
};

class App extends Component {

  render() {
    return (
      <div>
          <Line data={data}/>
          <Chart data={data}/>
      </div>
    );
  }
}

export default App;
