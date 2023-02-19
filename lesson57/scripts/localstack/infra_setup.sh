#!/bin/bash

set -ex

awslocal s3 mb s3://test --region us-east-1
awslocal s3api put-bucket-acl --bucket test --acl public-read-write

echo "INFRA SETUP FINISHED"
