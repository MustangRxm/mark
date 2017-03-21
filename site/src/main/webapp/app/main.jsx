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
var articleDataList=[
  {
    category:'目录A',
    author:'authorA',
    title:'titleA',
    text:'I AM TEXT',
    createDatetime:'2017-03-21',
    tagList:['TG1','TG2']

  },
  {
    category:'目录B',
    author:'authorB',
    title:'titleB',
    text:'I AM TEXTB',
    createDatetime:'2017-03-21',
    tagList:['TG1B','TG2B']

  }
];
const App = () => (

  <MuiThemeProvider
    muiTheme={muiTheme}
  >
    <div >
  <MHeader/>
    <div style={{
      display:'flex',
      marginTop:20
    }}>
    <MainBody data={articleDataList}/>
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
