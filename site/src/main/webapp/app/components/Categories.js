/**
 * Created by Administrator on 2017/3/9 0009.
 */
import React from "react";
import Paper from "material-ui/Paper";
import Divider from "material-ui/Divider";
import CategoryItem from "./CategoryItem";
import FontIcon from "material-ui/FontIcon";
const iconStyles = {
  // marginRight: 24,

  fontSize:'18px'
};

export default class Categories extends React.Component{
  constructor(props){
    super(props);
    this.setState({
      dataList: []
    });
  }
  // getInitialState(){
  //   console.log('init');
  //   return {
  //     dataList: []
  //   };
  //
  // }
  // componentWillMount(){
  //   this.setState({
  //     dataList:[
  //       {title:'i am title1',tagId:123,relNum:5},
  //       {title:'i am title12',tagId:456,relNum:6},
  //       {title:'i am title13',tagId:789,relNum:7}
  //     ]
  //   });
  //   console.log(this.state.dataList);
  //
  // }
  componentWillMount(){
    // console.log('will mount');
    this.setState({
      dataList:[
        {title:'i am title1',tagId:123,relNum:5},
        {title:'i am title12',tagId:456,relNum:6},
        {title:'i am title13',tagId:789,relNum:7}
      ]
    });
  }
  render (){
    return (
      <Paper zDepth={2} >
        <div style={{
          padding:5,
          marginLeft:5,
          display:'flex',
          alignItems:'center',
        }}> <FontIcon className="material-icons md-light  md-48" Style={iconStyles}>view_list</FontIcon>

          <h4>Categories</h4></div>
        <Divider/>
        {this.state.dataList.map(function (item,i) {
          return <CategoryItem key={i} title={item.title} tagId={item.tagId} relNum={item.relNum}/>
        })}
        {/*<CategoryItem/>*/}
        {/*<Divider/>*/}
        {/*<CategoryItem/>*/}
        {/*<Divider/>*/}
        {/*<CategoryItem/>*/}
      </Paper>
    );
  };
};
