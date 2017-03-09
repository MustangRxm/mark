/**
 * Created by Administrator on 2017/2/26 0026.
 */
// document.write('<h1>Hello World</h1>');
import React from 'react';
import ReactDOM from 'react-dom'; //内部方法?
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import MHeader from './components/MHeader';
import MFooter from './components/MFooter';
import MainBody from './components/MainBody';
import RightBody from './components/RightBody';

const App = () => (
  <MuiThemeProvider>
    <div style={ {
    }}>
  <MHeader/>
    <div style={{
      display:'flex',
      marginTop:20
    }}>
    <MainBody/>
    <RightBody />
    </div>
    <MFooter />

    </div>
  </MuiThemeProvider>
);




ReactDOM.render(
  <App />,
  document.getElementById('app')
);
