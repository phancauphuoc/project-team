
import { Typography } from "@mui/material";
import { ProductMetaWrapper } from "../../../styles/product";


/**
 * 
 * @Author: Bich Ngoc 
 */
export default function ProductMeta({ product, matches }) {
    return (
      <ProductMetaWrapper>
        <Typography variant={matches ? "h6" : "h5"} lineHeight={2}>
          {product.productName}
        </Typography>
        <Typography variant={matches ? "caption" : "body1"}>
          ${product.unitPrice}
        </Typography>
        
      </ProductMetaWrapper>
    );
}