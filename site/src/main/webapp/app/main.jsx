/**
 * Created by Administrator on 2017/2/26 0026.
 */
// document.write('<h1>Hello World</h1>');
import React from 'react';
import ReactDOM from 'react-dom'; //内部方法?
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import getMuiTheme from 'material-ui/styles/getMuiTheme';
import {grey700,grey50,indigo100} from 'material-ui/styles/colors';
import MHeader from './components/MHeader';
import MFooter from './components/MFooter';
import MainBody from './components/MainBody';
import RightBody from './components/RightBody';
const muiTheme = getMuiTheme({
  //支持很多控件的主题设置
  palette: {
    textColor: grey700,
  },
  appBar: {
    height: 50,
    color:grey700
  },
  paper: {
    // color: palette.textColor,
    // backgroundColor: grey700
  },
  flatButton:{
    textColor:grey50
  },
  chip:{
    backgroundColor:indigo100,
    textColor:grey50
  }
});
const App = () => (
  <MuiThemeProvider
    muiTheme={muiTheme}
  >
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
