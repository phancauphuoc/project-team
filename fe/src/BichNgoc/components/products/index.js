import { Box, Button, Container, Grid } from "@mui/material";

import SingleProduct from "./SingleProduct";
import { useTheme } from "@mui/material/styles";
import { useMediaQuery } from "@mui/material";
import SingleProductDesktop from "./SingleProductDesktop";
import ProductByCategoryService from '../../services/ProductByCategoryService';
import { useEffect, useState } from "react";

import Category from "../productByCategory/Category";


/**
 * 
 * @Author: Bich Ngoc
 */

export default function Products(props) {
  const theme = useTheme();
  const matches = useMediaQuery(theme.breakpoints.down("md"));
  const [productList, setProductList] = useState([]);
  
  
  useEffect(() =>{
    ProductByCategoryService.listProductAo(props.id).then((res) =>{
      setProductList(res.data)
    })
  }, [])
 



  const renderProducts = productList.map((product) => (
    <Grid item key={product.id} xs={2} sm={4} md={4} display="flex" flexDirection={'column'} alignItems="center">
      {matches ? (
        <SingleProduct product={product} matches={matches} />
      ) : (
        <SingleProductDesktop product={product} matches={matches} />
      )}
    </Grid>
  ));




  return (
    <Container>
      <Grid        
        container
        spacing={{ xs: 2, md: 3 }}
        justifyContent="center"
        sx={{ margin: `20px 4px 10px 4px` }}
        columns={{ xs: 4, sm: 8, md: 12 }}
      >
        {renderProducts}
      </Grid>
    </Container>
  );
}
