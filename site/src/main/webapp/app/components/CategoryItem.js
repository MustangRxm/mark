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
    console.log(event.target);
    console.log(event.target.innerHTML);
    // console.log(this.props.tagId);
  }

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
        <Chip
              style={{  display: 'flex',
                alignItems: 'center',
                marginRight: 10,
                height: 15,marginTop:5,marginBottom:5,fontSize:5}}
              onTouchTap={this.handleTouchTap}
        >
          {this.props.relNum}
          {/*<a href={this.props.href} >{this.props.relNum}</a>*/}

        </Chip>
        <Divider/>
      </div>
    );
  };
}
