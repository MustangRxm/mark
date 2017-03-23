/**
 * Created by Administrator on 2017/3/5 0005.
 */
import React from "react";
import Chip from 'material-ui/Chip';
import Divider from "material-ui/Divider";

// const CategoryItem = () => (
//
// );
export default class CategoryItem extends React.Component{
  handleTouchTap(event){
    console.log('touch');
    console.log(event);
    // console.log(this.props.tagId);
  }
test(){}

  render(){
    return (
      <div style={{
        display:'flex',
        justifyContent:'space-between',
        paddingLeft:20,
        paddingRight:20,
        alignItems:'center'
      }}>
        <a href="#">{this.props.title}</a>
        <Chip onTouchTap={this.handleTouchTap}
              style={{  display: 'flex',
                alignItems: 'center',
                marginRight: 10,
                height: 15,marginTop:5,marginBottom:5,fontSize:5}}
        ><p style={{fontSize:10,fontcolor:'#00ff00'}}>{this.props.relNum + this.props.tagId}</p></Chip>
        <Divider/>
      </div>
    );
  };
}
